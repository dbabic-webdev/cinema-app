import React, { useState, useEffect } from "react";
import ProjectionList from "./ProjectionList";
import CinemaAxios from "../../apis/CinemaAxios";
import { Button, Form, Collapse } from "react-bootstrap";

const Projections = () => {
  const [projekcije, setProjekcije] = useState([]);
  const [pageNo, setPageNo] = useState("");
  const [totalPages, setTotalPages] = useState("");
  const [showSearchForm, setShowSearchForm] = useState(false);
  const [tip, setTip] = useState("");
  const [cenaKarteOd, setCenaKarteOd] = useState("");

  useEffect(() => {
    getProjections(0);
  }, []);

  function getProjections(pageNo) {
    let config = {
      params: {
        pageNo,
      },
    };
    CinemaAxios.get("/projekcije", config)
      .then((res) => {
        console.log(res);
        setProjekcije(res.data);
        setTotalPages(res.headers["total-pages"]);
        setPageNo(pageNo);
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't fetch projections");
      });
  }

  const changePage = (direction) => {
    const page = pageNo + direction;
    getProjections(page);
  };

  const tipProjekcijeChange = (event) => {
    setTip(event.target.value);
  };

  const cenaKarteOdChange = (event) => {
    setCenaKarteOd(event.target.value);
  };

  return (
    <div>
      <Form.Group style={{ marginTop: 35 }}>
        <Form.Check
          type="checkbox"
          label="Show search form"
          onClick={(event) => setShowSearchForm(event.target.checked)}
        />
      </Form.Group>
      <Collapse in={showSearchForm}>
        <Form style={{ marginTop: 10 }}>
          <Form.Group>
            <Form.Label>Naziv filma</Form.Label>
            <Form.Control name="naziv" as="input"></Form.Control>
          </Form.Group>
          <Form.Label htmlFor="pTip">Tip projekcije</Form.Label>
          <Form.Control
            name="tip"
            as="select"
            value={tip}
            id="tip"
            onChange={(e) => tipProjekcijeChange(e)}
          >
            <option></option>
            <option value="2D">2D</option>
            <option value="3D">3D</option>
            <option value="4D">4D</option>
          </Form.Control>
          <Form.Group>
            <Form.Label>Cena karte od:</Form.Label>
            <Form.Control
              onChange={(event) => cenaKarteOdChange(event)}
              name="cenaKarteOd"
              value={cenaKarteOd}
              as="input"
              type="number"
              step="0.1"
            ></Form.Control>
          </Form.Group>
        </Form>
      </Collapse>
      <ProjectionList projections={projekcije} />
      <Button disabled={pageNo == 0} onClick={() => changePage(-1)}>
        Previous
      </Button>
      <Button disabled={totalPages == pageNo + 1} onClick={() => changePage(1)}>
        Next
      </Button>
    </div>
  );
};

export default Projections;
