import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import { Container, Paper, Button } from "@mui/material";
import TextField from "@mui/material/TextField";

export default function ViewGarden() {
  // Initializes state to an empty array
  const [gardens, setGardens] = useState([]);
  const [searchQuery, setSearchQuery] = useState("");

  // Sets gardens to json
  useEffect(() => {
    fetch("http://localhost:8080/gardens/view-gardens")
      .then((res) => res.json())
      .then((result) => {
        setGardens(result);
      })
      // ERROR CATCH
      .catch((error) => {
        console.error("Error fetching Garden data:", error);
      });
  }, []);

  // Search function
  useEffect(() => {
    fetch("http://localhost:8080/search/byGarden?query=" + searchQuery)
      .then((res) => res.json())
      .then((result) => {
        setGardens(result);
      })
      // ERROR CATCH
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
      <h1 style={{ padding: 10 }}>GARDEN DATABASE</h1>
      <Container>
        <Paper>
          <h1>Gardens</h1>
          <div>
            <TextField
              required
              id="outlined-required"
              label="searchTerm"
              defaultValue="Search for a Garden"
            />
            <Button
              variant="contained"
              color="primary"
              onClick={(e) => {
                setSearchQuery(e.target.value);
              }}
            >
              Search for Gardens
            </Button>
          </div>
          {gardens.map((garden) => (
            <Paper key={garden.id}>
              <h4>{garden.name} Details:</h4>
              Id: {garden.id} <br />
              Description: {garden.description} <br />
              Seeds:
              {garden.gardenSeeds.map((seed) => (
                <div key={seed.id}>
                  <ul>
                    <li>Name: {seed.name}</li>
                    <li>Description: {seed.description}</li>
                    <li>Growing Zone:{seed.growingZone}</li>
                    <li>Days to Germination: {seed.daysToGermination}</li>
                    <li>Annual or Perennial: {seed.annualOrPerennial}</li>
                  </ul>
                </div>
              ))}
              Plants:
              {garden.gardenPlants.map((plant) => (
                <div key={garden.id}>
                  <ul>
                    <li>Name: {plant.name}</li>
                    <li>Description: {plant.description}</li>
                    <li>Growing Zone:{plant.growingZone}</li>
                    <li>Annual or Perennial: {plant.annualOrPerennial}</li>
                  </ul>
                </div>
              ))}
              Soil:
              <div>
                <ul>
                  <li>{garden.gardenSoil.name}</li>
                  <li>{garden.gardenSoil.description}</li>
                  <li>{garden.gardenSoil.type}</li>
                </ul>
              </div>
              <br />
            </Paper>
          ))}
        </Paper>
      </Container>
    </Box>
  );
}
