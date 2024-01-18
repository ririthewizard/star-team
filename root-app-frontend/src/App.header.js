import React from 'react';
import { Link } from 'react-router-dom';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';

const AppHeader = ({ loggedIn }) => {
  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          <b>ROOT: </b> The garden builder application
        </Typography>
        <div className="nav">
          {!loggedIn ? (
            <>
              <Button component={Link} to="/login" color="inherit">
                Log In
              </Button>
              <Button component={Link} to="/register" color="inherit">
                Register
              </Button>
            </>
          ) : (
            <>
              <Button component={Link} to="/journal/add" color="inherit">
                Add Journal
              </Button>
              {/* Add other links for logged-in users */}
              <Button component={Link} to="/logout" color="inherit">
                Log Out
              </Button>
            </>
          )}
        </div>
      </Toolbar>
    </AppBar>
  );
};

export default AppHeader;
