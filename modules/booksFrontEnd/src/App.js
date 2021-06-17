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

  const toggle = () => setModal(!modal);

  useEffect(() => {
    retrieveBooks();
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

  return (
    <div>
      <h4>Book List</h4>
      <Table striped responsive>
        <thead>
          <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Writer</th>
            <th>Publication</th>
          </tr>
        </thead>
        <tbody>
          {books &&
            books.map((book) => (
              <tr key={book.isbn}>
                <td>{book.isbn}</td>
                <td>{book.title}</td>
                <td>{book.writer}</td>
                <td>{book.publication}</td>
              </tr>
            ))}
        </tbody>
      </Table>
      <Button color="success" onClick={toggle}>
        Add Book
      </Button>
      <Modal isOpen={modal} toggle={toggle}>
        <form>
          <ModalHeader toggle={toggle}>Modal title</ModalHeader>
          <ModalBody>
            <Label for="iDisbn">ISBN</Label>
            <Input
              type="number"
              name="isbn"
              id="iDisbn"
              onChange={(event) => setIsbn(event.target.value)}
            />
            <Label for="iDtitle">Title</Label>
            <Input
              type="text"
              name="title"
              id="iDtitle"
              onChange={(event) => setTitle(event.target.value)}
            />
            <Label for="iDwriter">Writer</Label>
            <Input
              type="text"
              name="writer"
              id="iDwriter"
              onChange={(event) => setWriter(event.target.value)}
            />
          </ModalBody>
          <ModalFooter>
            <Button color="primary" onClick={(event) => addBook(event)}>
              Add
            </Button>
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
