import React, { useState, useEffect } from "react";
import ReactDOM from "react-dom";
import "./index.css";
import { Route, Link, HashRouter as Router, Switch } from "react-router-dom";
import { Container, Navbar, Nav, Button, Form } from "react-bootstrap";
import NotFound from "./components/NotFound";
import { logout } from "./services/auth";
import Login from "./components/Login/Login";
import Home from "./components/Home";
import Projections from "./components/Projections/Projections";
import Movies from "./components/Movies/Movies";
import Movie from "./components/Movies/Movie";

const App = () => {
  return (
    <div>
      <Router>
        <Navbar bg="dark" variant="dark" expand>
          <Navbar.Brand as={Link} to="/">
            Cinema
          </Navbar.Brand>
          {/*className="mr-auto" podesi ovu grupu Nav Link-ova da se "rasire" sto je vise moguce,
              i zbog toga je dugme Log in/Log out skroz sa leve strane*/}
          <Nav className="mr-auto">
            <Nav.Link as={Link} to="/projekcije">
              Projections
            </Nav.Link>

            <Nav.Link as={Link} to="/filmovi">
              Movies
            </Nav.Link>
          </Nav>

          {window.localStorage["jwt"] ? (
            <Button onClick={() => logout()}>Log out</Button>
          ) : (
            <Nav.Link as={Link} to="/login">
              Log in
            </Nav.Link>
          )}
        </Navbar>
        <Container style={{ marginTop: 25 }}>
          <Switch>
            <Route exact path="/" component={Home} />
            <Route exact path="/projekcije" component={Projections} />
            <Route exact path="/filmovi" component={Movies} />
            <Route exact path="/filmovi/:id" component={Movie} />
            <Route exact path="/login" component={Login} />
            <Route component={NotFound} />
          </Switch>
        </Container>
      </Router>
    </div>
  );
};

export default App;
