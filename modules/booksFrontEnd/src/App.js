import React, { useState, useEffect } from "react";
import axios from "axios";

import {
  Button,
  Modal,
  ModalHeader,
  ModalBody,
  ModalFooter,
  Input,
  Label,
  Form,
  FormGroup,
  Table,
} from "reactstrap";

const App = () => {


  const baseUrl = "http://localhost/o/library/";
  let permisions = [];

  const [books, setBooks] = useState([]);
  const [modal, setModal] = useState(false);

  const [isbn, setIsbn] = useState(0);
  const [title, setTitle] = useState("");
  const [writer, setWriter] = useState("");
  const [date, setDate] = useState("");
  const [editMode,setEditMode]  = useState(false);

  const toggle = () => {
    setEditMode(false)
    setIsbn(0);
    setTitle("");
    setWriter("");
    setDate("");
    setModal(!modal);
  }

  const openEdit = (book) => {
    setEditMode(true)
    setIsbn(book.isbn);
    setTitle(book.title);
    setWriter(book.writer);
    setDate(new Date(book.publication).toISOString().substr(0,10));
    setModal(true);
  }

  useEffect(() => {
    retrieveBooks();
  }, []);


  const findBooks = (search) => {
    axios.get(baseUrl + "find",{params: {query: search}}).then((response) => {
      setBooks(response.data);
    });

  }

  const retrieveBooks = () => {
    axios.get(baseUrl + "getAll").then((response) => {
      setBooks(response.data);
    });
  };

  const retrieveSingleBook = (isbn) => {
    axios.get(baseUrl + "getOne",{params: {isbn: isbn}}).then((response) => {
      return response.data;
    });
  }

  const saveBooks = (book) => {
    axios.post(baseUrl, book).then((response) => {
      if (response.status === 200) {
        retrieveBooks();
      }
    });
  };

  const deleteBook = (book) => {
    axios.delete(baseUrl, book).then((response) => {
      if (response.status === 200) {
        retrieveBooks();
      }
    });
  }

  const editBook = () => {
    
    const newBook = {
      isbn: parseInt(isbn),
      title,
      writer,
      publication: date,
    };
    axios.put(baseUrl + "update",{
      newBook
    }).then(response => {
      if (response.status === 200) {
        retrieveBooks();
      }
    })
  }

  const addBook = (event) => {
    // event.preventDefault();

    const bookAdded = {
      isbn: parseInt(isbn),
      title,
      writer,
      publication: date,
    };

    saveBooks(bookAdded);
    toggle();
  };



  const guestContent = (books) => {

    return(
      <tbody>
        {books &&
        books.map((book) => (
          <tr key={book.isbn}>
            <td>{book.isbn}</td>
            <td>{book.title}</td>
            <td>{book.writer}</td>
            <td>{new Date(book.publication).toLocaleDateString()}</td>
            <td>
              
            </td>
          </tr>
        ))}
      </tbody>
    );
  }

  const adminContent = (books) => {

    return(
      <tbody>
        {books &&
        books.map((book) => (
          <tr key={book.isbn}>
            <td>{book.isbn}</td>
            <td>{book.title}</td>
            <td>{book.writer}</td>
            <td>{new Date(book.publication).toLocaleDateString()}</td>
            <td>
              {permisions.indexOf("edit-book") != -1 && <Button active={} color="secundary" onClick={(event) => openEdit(book)}>
                Edit
              </Button>}
              {permisions.indexOf("delete-book") != -1 && <Button color="danger" onClick={(event) => deleteBook(book)}>
                Delete
              </Button>}
            </td>
          </tr>
        ))}
      </tbody>
    );
  }

  return (
    <div>
      <form class="form-search">
       <Input
          class="input-medium search-query"
          placeholder="Search"
          type="search"
          name="writer"
          onChange={(event) => findBooks(event.target.value)}
            />

      </form>
      <h4>Book List</h4>
      <Table striped responsive>
        <thead>
          <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Writer</th>
            <th>Publication</th>
            <th>Options</th>
          </tr>
        </thead>  
        {(Liferay.ThemeDisplay.getUserName() === "")
         ? guestContent(books)
         : adminContent(books)  }
        
      </Table>
      {Liferay.ThemeDisplay.isSignedIn() && 
        <Button color="success" onClick={toggle}>
          Add Book
        </Button>
      }

      <Modal isOpen={modal} toggle={toggle}>
        <form>
          <ModalHeader toggle={toggle}>{editMode ? "Save Book" : "Add Book"}</ModalHeader>
          <ModalBody>
            <Label for="iDisbn">ISBN</Label>
            <Input
              disabled={editMode}
              type="number"
              name="isbn"
              id="iDisbn"
              value={isbn}
              onChange={(event) =>  setIsbn(event.target.value)}
            />
            <Label for="iDtitle">Title</Label>
            <Input
              type="text"
              name="title"
              id="iDtitle"
              value={title}
              onChange={(event) => setTitle(event.target.value)}
            />
            <Label for="iDwriter">Writer</Label>
            <Input
              type="text"
              name="writer"
              id="iDwriter"
              value={writer}
              onChange={(event) => setWriter(event.target.value)}
            />
            <Label for="iDdate">Date</Label>
            <Input
              type="date"
              name="date"
              id="iDdate"
              value={date}
              onChange={(event) => setDate(event.target.value)}
            />
          </ModalBody>
          <ModalFooter>

            {editMode
            ? <Button color="primary" onClick={(event) =>  editBook(event)}>Save</Button>
            : <Button color="primary" onClick={(event) =>  addBook(event)}>Add</Button>}
            <Button color="danger" onClick={toggle}> 
              Cancel
            </Button>
          </ModalFooter>
        </form>
      </Modal>
    </div>
  );
};

export default App;