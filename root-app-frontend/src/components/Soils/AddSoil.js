import React, { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Container, Paper, Button } from "@mui/material";

export default function AddSoil() {
  // FOR POST
  // THESE MUST EXACTLY MATCH THE FIELDS CREATED IN THE BACKEND
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [type, setType] = useState("");

  // EVENT HANDLER FOR SUBMITTING A SOIL TO DATABASE

  const handleSoilSubmission = (e) => {
    e.preventDefault();
    let soil = {
      name,
      description,
      type,
    };
    // CONSOLE LOG TO CONFIRM THAT DATA IS SAVED TO JSON FORMAT
    console.log(soil);
    fetch("http://localhost:8080/soil/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(soil),
    })
      // CONSOLE LOG TO CONFIRM IN CONSOLE THAT SOIL IS ADDED
      .then(() => {
        console.log("New soil added");
      })
      // ERROR CATCH
      .catch((error) => {
        console.error("Error adding soil:", error);
      });
  };

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
          <h1 style={{ padding: 10 }}>ADD SOIL</h1>
          <div>
            {/* NAME */}
            <TextField
              required
              id="outlined-required"
              label="Soil Name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
            {/* DESCRIPTION */}
            <TextField
              required
              id="outlined-required"
              label="Soil Description"
              helperText="Max of 255 characters"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
            {/* GROWING ZONE */}
            <TextField
              required
              id="outlined-required"
              label="Type"
              value={type}
              onChange={(e) => setType(e.target.value)}
            />
          </div>
          <Button variant="contained" onClick={handleSoilSubmission}>
            SUBMIT
          </Button>
        </Paper>
      </Container>
    </Box>
  );
}
