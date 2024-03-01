import React, { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Container, Paper, Button } from "@mui/material";

export default function AddPlant() {
  // FOR POST
  // THESE MUST EXACTLY MATCH THE FIELDS CREATED IN THE BACKEND
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [growingZone, setGrowingZone] = useState("");
  const [annualOrPerennial, setAnnualOrPerennial] = useState("");

  // ERRORS
  const [errors, setErrors] = useState({});

  // EVENT HANDLER FOR SUBMITTING A PLANT TO DATABASE

  const handlePlantSubmission = (e) => {
    e.preventDefault();
    let plant = {
      name,
      description,
      growingZone,
      annualOrPerennial,
    };
    // CONSOLE LOG TO CONFIRM THAT DATA IS SAVED TO JSON FORMAT
    console.log(plant);
    const inputErrors = validatePlant(plant);
    if (Object.keys(inputErrors).length === 0) {
      fetch("http://localhost:8080/plants/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(plant),
      })
        // CONSOLE LOG TO CONFIRM IN CONSOLE THAT PLANT IS ADDED
        .then(() => {
          console.log("New plant added");
        })
        // ERROR CATCH
        .catch((error) => {
          console.error("Error adding plant:", error);
        });
    } else {
      setErrors(inputErrors);
    }
  };

  // VALIDATION FUNCTION

  const validatePlant = (data) => {
    let errors = {};

    if (!data.name.trim()) {
      errors.name = "Seed name is required!";
    }

    if (!data.description.trim()) {
      errors.description = "Seed description is required!";
    }

    if (!data.growingZone.trim()) {
      errors.growingZone = "Seed growing zone is required!";
    }

    if (!data.annualOrPerennial.trim()) {
      errors.annualOrPerennial = "Annual / perennial is required!";
    }

    return errors;
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
          <h1 style={{ padding: 10 }}>ADD PLANTS</h1>
          <div>
            {/* NAME */}
            <TextField
              required
              id="outlined-required"
              label="Plant Name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
            <p>{errors.name && <span>{errors.name}</span>}</p>
            {/* DESCRIPTION */}
            <TextField
              required
              id="outlined-required"
              label="Plant Description"
              helperText="Max of 255 characters"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
            <p>{errors.description && <span>{errors.description}</span>}</p>
            {/* GROWING ZONE */}
            <TextField
              required
              id="outlined-required"
              label="Growing Zone"
              value={growingZone}
              onChange={(e) => setGrowingZone(e.target.value)}
            />
            <p>{errors.growingZone && <span>{errors.growingZone}</span>}</p>
            {/* ANNUAL OR PERENNIAL */}
            <TextField
              required
              id="outlined-required"
              label="Annual or Perennial"
              value={annualOrPerennial}
              onChange={(e) => setAnnualOrPerennial(e.target.value)}
            />
            <p>
              {errors.annualOrPerennial && (
                <span>{errors.annualOrPerennial}</span>
              )}
            </p>
          </div>
          <Button variant="contained" onClick={handlePlantSubmission}>
            SUBMIT
          </Button>
        </Paper>
      </Container>
    </Box>
  );
}
