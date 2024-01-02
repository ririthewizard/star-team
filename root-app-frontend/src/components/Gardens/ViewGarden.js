import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import { Container, Paper } from "@mui/material";

export default function ViewGarden() {
  // Initializes state to an empty array
  const [gardens, setGardens] = useState([]);

  // Sets plants to json
  useEffect(() => {
    fetch("http://localhost:8080/gardens/view-gardens")
      .then((res) => res.json())
      .then((result) => {
        setGardens(result);
      })
      .catch((error) => {
        console.error("Error fetching Garden data:", error);
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
      <h1>GARDEN DATABASE</h1>
      <Container>
        <Paper>
          <h1>Gardens</h1>
          {gardens.map((garden) => (
            <Paper key={garden.id}>
              Id: {garden.id} <br />
              Name: {garden.name} <br />
              Description: {garden.description} <br />
              Seeds: {garden.seeds} <br />
              Plants: {garden.plants} <br />
              Soil: {garden.soil} <br />
              <br />
            </Paper>
          ))}
        </Paper>
      </Container>
    </Box>
  );
}
