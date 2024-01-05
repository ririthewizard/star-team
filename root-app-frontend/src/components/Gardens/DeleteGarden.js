import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import {
  Container,
  Paper,
  Button,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
} from "@mui/material";

export default function DeleteGarden() {
  // Initializes state to an empty array

  // FOR
  const [gardens, setGardens] = useState([]);

  //

  const handleDeleteGardenSubmission = (e) => {
    e.preventDefault();
    let garden = {
      name,
      description,
      gardenSeeds,
      gardenPlants,
      gardenSoil,
    };

    // CONSOLE LOG TO CONFIRM THAT DATA IS SAVED TO JSON FORMAT
    console.log(garden);
    fetch("http://localhost:8080/gardens/view", {
      method: "DELETE",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(garden),
    }).then(() => {
      console.log("Garden Deleted");
    });
  };

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
      <h1 style={{ padding: 10 }}>CHOOSE A GARDEN TO DELETE</h1>
      <Container>
        <Paper>
          <form>
            <FormControl fullWidth>
              <InputLabel>Select a Garden</InputLabel>
              <Select
                multiple
                value={gardens}
                onChange={(e) => setGardens(e.target.value)}
              >
                {gardens.map((aGarden) => (
                  <MenuItem key={aGarden.id} value={aGarden.id}>
                    {aGarden.name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>
            <Button
              variant="contained"
              color="primary"
              onClick={handleDeleteGardenSubmission}
            >
              Build Your Garden
            </Button>
          </form>
        </Paper>
      </Container>
    </Box>
  );
}
