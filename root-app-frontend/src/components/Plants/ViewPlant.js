import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import { Container, Paper } from "@mui/material";

export default function ViewPlant() {
  // Initializes state to an empty array
  const [plants, setPlants] = useState([]);

  // Sets plants to json
  useEffect(() => {
    fetch("http://localhost:8080/plants/view-plants")
      .then((res) => res.json())
      .then((result) => {
        setPlants(result);
      })
      // ERROR CATCH
      .catch((error) => {
        console.error("Error fetching Plant data:", error);
      });
  }, []);

  return (
    <Box
      component="body"
      sx={{
        "& .MuiTextField-root": { m: 1, width: "25ch" },
      }}
      noValidate
      autoComplete="off"
    >
      <h1>PLANT DATABASE</h1>
      <Container>
        <Paper>
          <h1>Plants</h1>
          {plants.map((plant) => (
            <Paper key={plant.id}>
              Id: {plant.id} <br />
              Name: {plant.name} <br />
              Description: {plant.description} <br />
              Growing Zone: {plant.growingZone} <br />
              Annual or Perennial: {plant.annualOrPerennial} <br /> <br />
            </Paper>
          ))}
        </Paper>
      </Container>
    </Box>
  );
}
