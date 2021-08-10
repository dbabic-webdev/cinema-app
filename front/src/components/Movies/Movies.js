import React, { useState, useEffect } from "react";
import { Form, Button, Collapse } from "react-bootstrap";
import MoviesList from "./MoviesList";
import CinemaAxios from "../../apis/CinemaAxios";
import NewMovie from "./NewMovie";

const Movies = () => {
  const [filmovi, setFilmovi] = useState([]);
  const [naziv, setNazivSearch] = useState("");
  const [zanrovi, setZanroviSearch] = useState("");
  const [showSearchForm, setSearchForm] = useState(false);
  const [trajanjeOd, setTrajanjeOd] = useState();
  const [trajanjeDo, setTrajanjeDo] = useState();
  const [pageNo, setPageNo] = useState("");
  const [totalPages, setTotalPages] = useState("");

  useEffect(() => {
    getMovies(0);
  }, []);

  const searchNazivValueInputChange = (event) => {
    setNazivSearch(event.target.value);
    getMovies(pageNo);
  };

  const searchZanroviValueInputChange = (event) => {
    setZanroviSearch(event.target.value);
    getMovies(pageNo);
  };

  const minDurationChange = (event) => {
    setTrajanjeOd(event.target.value);
    getMovies(pageNo);
  };

  const maxDurationChange = (event) => {
    setTrajanjeDo(event.target.value);
    getMovies(pageNo);
  };

  const addMovieHandler = (movie) => {
    CinemaAxios.post("/filmovi", movie)
      .then((res) => {
        console.log(res);

        alert("Uspesno ste dodali film!");
        window.location.reload();
      })
      .catch((error) => {
        console.log(error);

        alert("Greska! Neuspesno dodavanje filma");
      });
  };

  function getMovies(pageNo) {
    let config = {
      params: {
        pageNo: pageNo,
        naziv: naziv,
        zanrovi: zanrovi,
        trajanjeOd: trajanjeOd,
        trajanjeDo: trajanjeDo,
      },
    };
    CinemaAxios.get("/filmovi", config)
      .then((res) => {
        console.log(res);
        setFilmovi(res.data);
        setTotalPages(res.headers["total-pages"]);
        setPageNo(pageNo);
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't fetch movies");
      });
  }

  const changePage = (direction) => {
    const page = pageNo + direction;
    getMovies(page);
  };

  return (
    <div>
      {window.localStorage["role"] == "ROLE_ADMIN"
        ? [<NewMovie onAddMovie={addMovieHandler} />]
        : null}
      <Form.Group style={{ marginTop: 35 }}>
        <Form.Check
          type="checkbox"
          label="Show search form"
          onClick={(event) => setSearchForm(event.target.checked)}
        />
      </Form.Group>
      <Collapse in={showSearchForm}>
        <Form style={{ marginTop: 10 }}>
          <Form.Group>
            <Form.Label>Naziv filma</Form.Label>
            <Form.Control
              onChange={(event) => searchNazivValueInputChange(event)}
              name="naziv"
              value={naziv}
              as="input"
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Zanrovi</Form.Label>
            <Form.Control
              onChange={(event) => searchZanroviValueInputChange(event)}
              name="zanrovi"
              value={zanrovi}
              as="input"
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Trajanje od:</Form.Label>
            <Form.Control
              value={trajanjeOd}
              name="trajanjeOd"
              as="input"
              type="number"
              onChange={(e) => minDurationChange(e)}
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Trajanje do:</Form.Label>
            <Form.Control
              value={trajanjeDo}
              name="trajanjeDo"
              as="input"
              type="number"
              onChange={(e) => maxDurationChange(e)}
            ></Form.Control>
          </Form.Group>
        </Form>
      </Collapse>

      <MoviesList movies={filmovi} />
      <Button disabled={pageNo == 0} onClick={() => changePage(-1)}>
        Previous
      </Button>
      <Button disabled={totalPages == pageNo + 1} onClick={() => changePage(1)}>
        Next
      </Button>
    </div>
  );
};

export default Movies;
