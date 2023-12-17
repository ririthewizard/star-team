import React, { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Container, Paper, Button } from "@mui/material";

// SOURCE CODE WITH OTHER EXAMPLES HERE: https://mui.com/material-ui/react-text-field/#form-props

export default function SeedForm() {
  // FOR POST
  // THESE MUST EXACTLY MATCH THE FIELDS CREATED IN THE BACKEND
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [growingZone, setGrowingZone] = useState("");
  const [daysToGermination, setDaysToGermination] = useState("");
  const [annualOrPerennial, setAnnualOrPerennial] = useState("");

  // FOR GET
  // const [seeds, setSeeds] = useState("");

  // EVENT HANDLER FOR SUBMITTING A SEED TO DATABASE

  const handleSeedSubmission = (e) => {
    e.preventDefault();
    let seed = {
      name,
      description,
      growingZone,
      daysToGermination,
      annualOrPerennial,
    };
    // CONSOLE LOG TO CONFIRM THAT DATA IS SAVED TO JSON FORMAT
    console.log(seed);
    fetch("http://localhost:8080/seeds/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(seed),
    }).then(() => {
      console.log("New seed added");
    });
  };

  /* GET SEEDS IF NEEDED
  REPLACE TOP IMPORT STAREMENT WITH 
  import React, { useEffect, useState } from "react";
*/

  /*
  useEffect(() => {
    fetch("http://localhost:8080/seeds/view-seeds")
      .then((res) => res.json())
      .then((result) => {
        setSeeds(result);
      });
  }, []);

*/

  return (
    <Box
      component="form"
      sx={{
        "& .MuiTextField-root": { m: 1, width: "25ch" },
      }}
      noValidate
      autoComplete="off"
    >
      <Container>
        <Paper>
          {/* UPDATE MARGINS*/}
          <h1 style={{ padding: 10 }}>ADD SEED</h1>
          <div>
            {/* NAME */}
            <TextField
              required
              id="outlined-required"
              label="Seed Name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
            {/* DESCRIPTION */}
            <TextField
              required
              id="outlined-required"
              label="Seed Description"
              helperText="Max of 255 characters"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
            {/* GROWING ZONE */}
            <TextField
              required
              id="outlined-required"
              label="Growing Zone"
              value={growingZone}
              onChange={(e) => setGrowingZone(e.target.value)}
            />
            {/* DAYS TO GERMINATION */}
            <TextField
              id="outlined-number"
              label="Days to Germination"
              type="number"
              InputLabelProps={{
                shrink: true,
              }}
              value={daysToGermination}
              onChange={(e) => setDaysToGermination(e.target.value)}
            />
            {/* ANNUAL OR PERENNIAL */}
            <TextField
              required
              id="outlined-required"
              label="Annual or Perennial"
              value={annualOrPerennial}
              onChange={(e) => setAnnualOrPerennial(e.target.value)}
            />
          </div>
          <Button variant="contained" onClick={handleSeedSubmission}>
            SUBMIT
          </Button>
        </Paper>
      </Container>
      {/* EXAMPLE OF SEEDS RETRIEVED FROM DATA BASE */}
      {/* <Container>
        <Paper>
          <h1>Seeds</h1>
          {seeds.map((seed) => (
            <Paper key={seed.id}>
              Id: {seed.id} <br />
              Name: {seed.name} <br />
              Description: {seed.description} <br />
              Growing Zone: {seed.growingZone} <br />
              Days to Germination: {seed.daysToGermination} <br />
              Annual or Perennial: {seed.annualOrPerennial} <br />
            </Paper>
          ))}
        </Paper>
      </Container> */}
    </Box>
  );
}
