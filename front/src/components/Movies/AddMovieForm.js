import React, { useState } from "react";
import {
  Row,
  Col,
  Button,
  Form,
  Collapse,
  InputGroup,
  FormControl,
} from "react-bootstrap";

const AddMovieForm = (props) => {
  const [naziv, setNaziv] = useState("");
  const [reziser, setReziser] = useState("");
  const [glumci, setGlumci] = useState("");
  const [zanrovi, setZanrovi] = useState("");
  const [trajanje, setTrajanje] = useState("");
  const [distributer, setDistributer] = useState("");
  const [zemljaPorekla, setZemljaPorekla] = useState("");
  const [godinaProizvodnje, setGodinaProizvodnje] = useState("");
  const [opis, setOpis] = useState("");
  const [hideAddForm, setHideAddForm] = useState(false);

  const nazivChangeHandler = (event) => {
    setNaziv(event.target.value);
  };

  const reziserChangeHandler = (event) => {
    setReziser(event.target.value);
  };

  const glumciChangeHandler = (event) => {
    setGlumci(event.target.value);
  };

  const zanroviChangeHandler = (event) => {
    setZanrovi(event.target.value);
  };

  const trajanjeChangeHandler = (event) => {
    setTrajanje(event.target.value);
  };

  const distributerChangeHandler = (event) => {
    setDistributer(event.target.value);
  };

  const zemljaPoreklaChangeHandler = (event) => {
    setZemljaPorekla(event.target.value);
  };

  const godinaProizvodnjeChangeHandler = (event) => {
    setGodinaProizvodnje(event.target.value);
  };

  const opisChangeHandler = (event) => {
    setOpis(event.target.value);
  };

  const submitHandler = (event) => {
    event.preventDefault();

    const movieData = {
      naziv: naziv,
      reziser: reziser,
      glumci: glumci,
      zanrovi: zanrovi,
      trajanje: trajanje,
      distributer: distributer,
      zemljaPorekla: zemljaPorekla,
      godinaProizvodnje: godinaProizvodnje,
      opis: opis,
    };

    props.onSaveMovie(movieData);
    setNaziv("");
    setReziser("");
    setTrajanje("");
    setZanrovi("");
    setZemljaPorekla("");
    setGlumci("");
    setDistributer("");
    setGodinaProizvodnje("");
    setOpis("");
  };

  return (
    <div>
      <Row>
        <Col></Col>
        <Col xs="12" sm="10" md="8">
          <h3>
            <small class="text-muted">Dodavanje filma</small>
          </h3>
          <Form.Group style={{ marginTop: 35 }}>
            <Form.Check
              type="checkbox"
              label="Show add form"
              onClick={(event) => setHideAddForm(event.target.checked)}
            />
          </Form.Group>
          <Collapse in={hideAddForm}>
            <Form>
              <Form.Label htmlFor="pNaziv">Naziv filma</Form.Label>
              <Form.Control
                id="pNaziv"
                name="naziv"
                value={naziv}
                onChange={nazivChangeHandler}
              />{" "}
              <br />
              <Form.Group>
                <Form.Label htmlFor="pReziser">Reziser</Form.Label>
                <Form.Control
                  name="reziser"
                  id="pPozicija"
                  value={reziser}
                  onChange={reziserChangeHandler}
                />
              </Form.Group>
              <Form.Group>
                <Form.Label htmlFor="pGlumci">Glumci</Form.Label>
                <Form.Control
                  id="glumci"
                  name="glumci"
                  value={glumci}
                  onChange={glumciChangeHandler}
                />{" "}
                <br />
              </Form.Group>
              <Form.Group>
                <Form.Label id="pZanrovi">Zanr</Form.Label>
                <Form.Control
                  id="pZanr"
                  name="zarovi"
                  value={zanrovi}
                  onChange={zanroviChangeHandler}
                />{" "}
                <br />
              </Form.Group>
              <Form.Group>
                <Form.Label htmlFor="pTrajanje">Trajanje</Form.Label>
                <Form.Control
                  type="number"
                  id="pTrajanje"
                  name="trajanje"
                  value={trajanje}
                  onChange={trajanjeChangeHandler}
                />
              </Form.Group>
              <Form.Group>
                <Form.Label htmlFor="pDistributer">Distributer</Form.Label>
                <Form.Control
                  id="pDistributer"
                  name="distributer"
                  value={distributer}
                  onChange={distributerChangeHandler}
                />
              </Form.Group>
              <Form.Group>
                <Form.Label htmlFor="pZemljaPorekla">Zemlja porekla</Form.Label>
                <Form.Control
                  id="pZemljaPorekla"
                  name="zemljaPorekla"
                  value={zemljaPorekla}
                  onChange={zemljaPoreklaChangeHandler}
                />
              </Form.Group>
              <Form.Group>
                <Form.Label htmlFor="pGodinaProizvodnje">
                  Godina proizvodnje
                </Form.Label>
                <Form.Control
                  type="number"
                  id="pGodinaProizvodnje"
                  name="godinaProizvodnje"
                  value={godinaProizvodnje}
                  onChange={godinaProizvodnjeChangeHandler}
                />
              </Form.Group>
              <Form.Group>
                <Form.Label htmlFor="pOpis">Opis</Form.Label>
                <Form.Control
                  id="pOpis"
                  name="opis"
                  value={opis}
                  onChange={opisChangeHandler}
                />
              </Form.Group>
              <Button onClick={submitHandler}>Add</Button>
            </Form>
          </Collapse>
        </Col>
        <Col></Col>
      </Row>
    </div>
  );
};

export default AddMovieForm;
