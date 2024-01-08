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

export default function EditGarden() {
  // GETS GARDENS
  const [gardens, setGardens] = useState([]);

  // FOR SELECTING A GARDEN TO EDIT
  const [selectedGardenId, setSelectedGardenId] = useState("");

  const handleEditGardenSubmission = () => {
    fetch(`http://localhost:8080/gardens/${selectedGardenId}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
    })
      // CONSOLE LOG TO CONFIRM IN CONSOLE THAT GARDEN IS UPDATED
      .then(() => {
        console.log("Garden Updated");
      })
      // ERROR CATCH
      .catch((error) => {
        console.error("Error updating Garden:", error);
      });
  };

  // Sets gardens to json
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
      <h1 style={{ padding: 10 }}>CHOOSE A GARDEN TO UPDATE</h1>
      <Container>
        <Paper>
          <form>
            <FormControl fullWidth>
              <InputLabel>Select a Garden</InputLabel>
              <Select
                value={selectedGardenId}
                onChange={(e) => setSelectedGardenId(e.target.value)}
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
              onClick={handleEditGardenSubmission}
            >
              Update your Garden
            </Button>
          </form>
        </Paper>
      </Container>
    </Box>
  );
}
