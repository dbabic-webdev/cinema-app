import React from "react";
import { useHistory } from "react-router-dom";
import { Table, Button } from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";

const MovieProjections = (props) => {
  let history = useHistory();

  const goToReservation = (id) => {
    history.push("/projekcije/rezervisi/" + id);
  };

  return (
    <React.Fragment>
      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Tip projekcije</th>
            <th>Sala</th>
            <th>Datum i vreme</th>
            <th>Cena karte</th>
            {window.localStorage["role"] === "ROLE_KORISNIK"
              ? [<th>Rezervisi</th>]
              : null}
          </tr>
        </thead>
        <tbody>
          {props.projections.map((projection) => (
            <tr key={projection.id}>
              <td>{projection.tip.naziv}</td>
              <td>{projection.sala.naziv}</td>
              <td>{projection.datumIVreme}</td>
              <td>{projection.cena}</td>
              {window.localStorage["role"] === "ROLE_KORISNIK"
                ? [
                    <td>
                      <Button onClick={() => goToReservation(projection.id)}>
                        Rezervisi
                      </Button>
                    </td>,
                  ]
                : null}
            </tr>
          ))}
        </tbody>
      </Table>
    </React.Fragment>
  );
};

export default MovieProjections;
