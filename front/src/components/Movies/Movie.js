import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import { Table, Button } from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";
import MovieProjections from "./MovieProjections";

const Movie = (props) => {
  const [film, setFilm] = useState({});
  const [projekcije, setProjekcije] = useState([]);

  let history = useHistory();

  useEffect(() => {
    getData();
  }, []);

  function getData() {
    getProjections(props.match.params.id);
    getMovieById(props.match.params.id);
  }

  const getMovieById = (id) => {
    CinemaAxios.get("/filmovi/" + id)
      .then((res) => {
        // handle success
        console.log(res);
        setFilm(res.data);
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Error occured please try again!");
      });
  };

  const getProjections = (id) => {
    CinemaAxios.get("/filmovi/" + id + "/projekcije")
      .then((res) => {
        // handle success
        console.log(res);
        // setProjekcije((result) => [...result, res.data]);
        setProjekcije(res.data);
        console.log(projekcije);
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Error occured please try again!");
      });
  };

  const goToReservation = (id) => {
    history.push("/projekcije/rezervisi/" + id);
  };

  return (
    <div>
      <Table className="table table-striped table-dark">
        <thead>
          <tr>
            <th>Naziv</th>
            <th>Reziser</th>
            <th>Glumci</th>
            <th>Zanrovi</th>
            <th>Trajanje</th>
            <th>Distributer</th>
            <th>Zemlja porekla</th>
            <th>Godina proizvodnje</th>
            <th>Opis</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{film.naziv}</td>
            <td>{film.reziser}</td>
            <td>{film.glumci}</td>
            <td>{film.zanrovi}</td>
            <td>{film.trajanje}</td>
            <td>{film.distributer}</td>
            <td>{film.zemljaPorekla}</td>
            <td>{film.godinaProizvodnje}</td>
            <td>{film.opis}</td>
          </tr>
        </tbody>
      </Table>
      <h3>Projekcije</h3>
      <MovieProjections projections={projekcije} />
    </div>
  );
};

export default Movie;
