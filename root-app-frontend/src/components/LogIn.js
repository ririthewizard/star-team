import React from 'react';
import { Grid, Paper,Avatar,TextField, Button, Typography, Link } from '@mui/material';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';


// import { green, pink } from '@mui/material/colors';
// import Avatar from '@mui/material/Avatar';
// import Stack from '@mui/material/Stack';
// import FolderIcon from '@mui/icons-material/Folder';
// import PageviewIcon from '@mui/icons-material/Pageview';
// import AssignmentIcon from '@mui/icons-material/Assignment';

const Login = () => {

    const paperStyle={ padding: '20px', width: '280px' }
    const avatarStyle={backgroundColor:'#38c4cbeb'}
    const btnstyle= {margin: '8px 0'}
    
  return (
    <Grid style={{ height: '70vh' }}>
      <Paper elevation={10} style={paperStyle}>
        <Grid align="center">
        <Avatar style={avatarStyle}> <LockOutlinedIcon></LockOutlinedIcon> </Avatar>
        
        <h2>Sign In</h2>
        </Grid>
        <TextField label='Username' placeholder='Enter Username'required></TextField>
        <TextField label='Password' placeholder='Enter Password'type='password' required></TextField>
        <FormControlLabel
          value="bottom"
          control={<Checkbox />}
          label="Remember me"
          labelPlacement="right"
        />

        <Button typr='submit' color='primary' variant='contained' style={btnstyle} fullWidth>Sign In</Button>  
        <Typography> 
         <Link href ='#'>  
        Forgot your password
        </Link></Typography> 
        <Typography>Are you registered?
         <Link href ='#'>  
       Register
        </Link></Typography>

               
      </Paper>
    </Grid>
  );
};

export default Login;
