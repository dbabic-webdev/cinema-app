import React from "react";
import AddMovieForm from "./AddMovieForm";

const NewMovie = (props) => {
  const saveMovieDataHandler = (enteredMovieData) => {
    const movieData = {
      ...enteredMovieData,
    };
    props.onAddMovie(movieData);
  };

  return (
    <div>
      <AddMovieForm onSaveMovie={saveMovieDataHandler} />
    </div>
  );
};

export default NewMovie;
