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

  const [books, setBooks] = useState([]);
  const [modal, setModal] = useState(false);

  const [isbn, setIsbn] = useState(0);
  const [title, setTitle] = useState("");
  const [writer, setWriter] = useState("");
  const [date, setDate] = useState("");

  const [edit, setEdit] = useState(false);
  const toggle = () => {
    setEdit(false);
    setIsbn(0);
    setTitle("");
    setWriter("");
    setDate("");
    setModal(!modal);
  }
  
  const REMOVE_BOOK = "removeBook";
  const UPDATE_BOOK = "updateBook";

  let permissions = [];

  useEffect(() => {
    retrieveBooks();
    getPermissions();
  }, []);

  const retrieveBooks = () => {
    axios.get(baseUrl + "getAll").then((response) => setBooks(response.data));
  };

  const saveBooks = (book) => {
    axios.post(baseUrl, book).then((response) => {
      if (response.status === 200) {
        retrieveBooks();
      }
    });
  };

  const addBook = (event) => {
    // event.preventDefault();

    const bookAdded = {
      isbn: parseInt(isbn),
      title,
      writer,
      publication: null,
    };

    saveBooks(bookAdded);
    toggle();
  };

  const removeBook = (book) => {
    axios.delete(baseUrl, book).then((response) => {
      if (response.status == 200) {
        retrieveBooks();
      }
    });
  };

  const updateBook = () => {
    const book = {
      isbn: parseInt(isbn),
      title,
      writer,
      publication: date,
    };
    
    axios.put(baseUrl + "update", {book}).then(response => {
      if (response.status == 200) {
        retrieveBooks();
      }
    });
  }

  const updateForm = (book) => {
    setEdit(true);
    setIsbn(book.isbn);
    setTitle(book.title);
    setWriter(book.writer);
    setDate(new Date(book.publication).toISOString().substr(0, 10));
    setModal(true);
  }

  const adminView = (books) => {
    return (
      <tbody>
        {books && books.map((book) => (
          <tr key={book.isbn}>
            <td>{book.isbn}</td>
            <td>{book.title}</td>
            <td>{book.writer}</td>
            <td>{new Date(book.publication).toLocaleDateString}</td>
            <td>
              {permissions.indexOf(REMOVE_BOOK) != -1 && <Button color="danger" onClick={(event) => removeBook(book)}>
                Remove
              </Button>}
              {permissions.indexOf(UPDATE_BOOK) != -1 && <Button color="secondary" onClick={(event) => updateForm(book)}>
                Update
              </Button>}              
            </td>
          </tr>
        ))}
      </tbody>
    );
  }
  
  const userView = (books) => {
    <tbody>
        {books && books.map((book) => (
          <tr key={book.isbn}>
            <td>{book.isbn}</td>
            <td>{book.title}</td>
            <td>{book.writer}</td>
            <td>{new Date(book.publication).toLocaleDateString}</td>
            <td></td>
          </tr>
        ))}
      </tbody>
  }

  const searchBooks = (search) => {
    axios.get(baseUrl + "search", {params: {query: query}}).then((response) => {
      setBooks(response.data);
    });
  }

  const getPermissions = () => {
    let userId = Number.parseInt(Liferay.ThemeDisplay.getUserId());
    axios.get(baseUrl + "getPermissions", {params: {userId: userId}}).then((response) => {
      permissions = response.data;
    });
  }

  return (
    <div>
      <form class="form-search">
        <Input
          class="input-medium search-query"
          placeholder="Search"
          type="search"
          onChange={(event) => searchBooks(event.target.value)}
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
            <th>Actions</th>
          </tr>
        </thead>
        {(Liferay.ThemeDisplay.getUserName() === "") ?
          userView(books) :
          adminView(books)
        }
        
      </Table>
      <Button color="success" onClick={toggle}>
        Add Book
      </Button>
      <Modal isOpen={modal} toggle={toggle}>
        <form>
          <ModalHeader toggle={toggle}>{edit? "Save Book" : "Add Book"}</ModalHeader>
          <ModalBody>
            <Label for="iDisbn">ISBN</Label>
            <Input
              type="number"
              name="isbn"
              id="iDisbn"
              value={isbn}
              onChange={(event) => setIsbn(event.target.value)}
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
            {edit ?
              <Button color="primary" onClick={(event) => updateBook(event)}>Save</Button> :
              <Button color="primary" onClick={(event) => addBook(event)}>Add</Button>
            }
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
