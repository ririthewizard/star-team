import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import { Container, Paper } from "@mui/material";

export default function ViewSoil() {
  // Initializes state to an empty array
  const [soils, setSoils] = useState([]);

  // Sets soils to json
  useEffect(() => {
    fetch("http://localhost:8080/soil/view-soils")
      .then((res) => res.json())
      .then((result) => {
        setSoils(result);
      })
      .catch((error) => {
        console.error("Error fetching Soil data:", error);
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
      <h1>SOIL DATABASE</h1>
      <Container>
        <Paper>
          <h1>Soils</h1>
          {soils.map((soil) => (
            <Paper key={soil.id}>
              Id: {soil.id} <br />
              Name: {soil.name} <br />
              Description: {soil.description} <br />
              Type: {soil.type} <br /> <br />
            </Paper>
          ))}
        </Paper>
      </Container>
    </Box>
  );
}
