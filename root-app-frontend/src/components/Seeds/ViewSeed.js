import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import { Container, Paper } from "@mui/material";

export default function ViewSeed() {
  // Initializes state to an empty array
  const [seeds, setSeeds] = useState([]);

  // Sets seeds to json
  useEffect(() => {
    fetch("http://localhost:8080/seeds/view-seeds")
      .then((res) => res.json())
      .then((result) => {
        setSeeds(result);
      })
      .catch((error) => {
        console.error("Error fetching Seed data:", error);
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
      <h1>SEED DATABASE</h1>
      <Container>
        <Paper>
          <h1>Seeds</h1>
          {seeds.map((seed) => (
            <Paper key={seed.id}>
              Id: {seed.id} <br />
              Name: {seed.name} <br />
              Description: {seed.description} <br />
              Growing Zone: {seed.growingZone} <br />
              Days to Germination: {seed.daysToGermination} <br />
              Annual or Perennial: {seed.annualOrPerennial} <br /> <br />
            </Paper>
          ))}
        </Paper>
      </Container>
    </Box>
  );
}
