import { useHistory } from "react-router-dom";
import React from "react";
import { Table, Button } from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";

const Projections = (props) => {
  let history = useHistory();

  const remove = (id) => {
    CinemaAxios.delete("/projekcije/" + id)
      .then((res) => {
        // handle success
        console.log(res);
        alert("Projection was deleted successfully!");
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
      <h1>Projekcije</h1>
      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Film</th>
            <th>Tip projekcije</th>
            <th>Sala</th>
            <th>Datum i vreme</th>
            <th>Cena karte</th>
            {window.localStorage["role"] === "ROLE_ADMIN"
              ? [<th>Delete</th>]
              : null}
          </tr>
        </thead>
        <tbody>
          {props.projections.map((projection) => (
            <tr key={props.id}>
              <td>{projection.film.naziv}</td>
              <td>{projection.tip.naziv}</td>
              <td>{projection.sala.naziv}</td>
              <td>{projection.datumIVreme}</td>
              <td>{projection.cena}</td>
              {window.localStorage["role"] === "ROLE_ADMIN"
                ? [
                    <td>
                      <Button
                        variant="danger"
                        onClick={() => remove(projection.id)}
                      >
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

export default Projections;
