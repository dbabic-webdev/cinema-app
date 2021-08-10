import React from "react";
import { Table, Button } from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";

const MoviesList = (props) => {
  const remove = (id) => {
    CinemaAxios.delete("/filmovi/" + id)
      .then((res) => {
        // handle success
        console.log(res);
        alert("Movie was deleted successfully!");
        window.location.reload();
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Error occured please try again!");
      });
  };

  return (
    <div>
      <h1>Filmovi</h1>

      <Table striped bordered hover variant="dark">
        <thead className="thead-dark">
          <tr key="nesto">
            <th>Naziv</th>
            <th>Trajanje</th>
            <th>Zanr</th>
            <th>Distributer</th>
            <th>Zemlja porekla</th>
            {window.localStorage["role"] === "ROLE_ADMIN"
              ? [<th>Delete</th>]
              : null}
          </tr>
        </thead>
        <tbody>
          {props.movies.map((movie) => (
            <tr key={movie.id}>
              <td>{movie.naziv}</td>
              <td>{movie.trajanje}</td>
              <td>{movie.zanrovi}</td>
              <td>{movie.distributer}</td>
              <td>{movie.zemljaPorekla}</td>
              {window.localStorage["role"] === "ROLE_ADMIN"
                ? [
                    <td>
                      <Button variant="danger" onClick={() => remove(movie.id)}>
                        Delete
                      </Button>
                    </td>,
                  ]
                : null}
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default MoviesList;
