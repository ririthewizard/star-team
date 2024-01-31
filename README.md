# Root

## Overview
Root is an innovative online garden builder and plant database created by 
Star Team ✨. Our project addresses the need for a high-quality, functional,
and dynamic application to help gardeners organize and visualize their plots. 
With Root, users can seamlessly add seeds, plants and soils to a comprehensive database, 
compile gardens from database entries, add journal entries, create personalized gardening plots, 
and access upcoming weather forecasts, and receive sage.

## Problem Statement
The gardening community lacks a reliable and feature-rich application for organizing 
and planning gardens. Root aims to fill this gap by providing users with tools to 
manage their seeds, plants, soils and gardens, visualize their garden plots, write journal entries, 
and receive weather forecasts. 

## Features
Root offers lgin and registration features, so amateur gardeners can sign up and log in with their chosen username and password.
Root features full CRUD functionality. Users are able to build gardens using seeds, plants and soils they enter into the database.
Users can also update old gardens with new information, or delete unwanted gardens. 
For note keeping, users can write and save journal entries in Root. 


## Technologies
Root is a full stack application, running a Spring Boot backend and a React frontend. 
Data persistence is maintained with MySQL.
The frontend incorporates Material UI component library for a more pleasing aesthetic. 
The application also calls an AccuWeather API to load a user's five-day forecast, based on the ZIP code they enter.

## Setup
From the github repository https://github.com/ririthewizard/star-team, clone the project down to your local machine.
The repository contains both the frontend and the backend components of the application. 
Within the Root\root-app-frontend\ directory, run npm install in the terminal. 
Using MySQL Workbench, set up a database with localhost:3306 as the port. Make sure your username and password in 
application.properties match the username and password you set up in MySQL Workbench.
Ensure that the backend is running on localhost:8080. When both are set up, run npm start in the terminal in root-app-frontend\. 
The application should open automatically in your browser. 

## Credits
Osmakova, Elena
Williams, Riley
Woodcock, Andrew