// import React from 'react';
// import { Link } from 'react-router-dom'; 


// const App = () => {
//   const loggedIn = false; // Set this based on  authentication logic

//   return (
//     <html lang="en">
      
//       <head>
//         <meta charSet="UTF-8" />
//         <title>ROOT</title>
//         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
//         <link
//           rel="stylesheet"
//           href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
//         />
//         <link rel="stylesheet" href="/css/styles.css" />
//         <link
//           rel="preconnect"
//           href="https://fonts.googleapis.com"
//         />
//         <link
//           rel="preconnect"
//           href="https://fonts.gstatic.com"
//           crossOrigin="true"
//         />
//         <link
//           href="https://fonts.googleapis.com/css2?family=Kodchasan:wght@200;400;700&family=Assistant:wght@400;700&display=swap"
//           rel="stylesheet"
//         />
//       </head>

//       <body>
//         <header>
//           <div id="mag">
//             <b>ROOT: </b> The garden builder application
//           </div>
//           <div className="nav">
//             {!loggedIn ? (
//               <>
//                 <Link className="navlink" to="/login">
//                   Log In
//                 </Link>
//                 <span style={{ marginLeft: '10px' }}></span>
//                 <Link className="navlink" to="/register">
//                   Register
//                 </Link>
//               </>
//             ) : (
//               <>
//                 <Link className="navlink" to="/journal/add">                
//                   Add Journal
//                 </Link>
//                 <Link className="navlink" to="/journal/view-journa">
//                   View Journal
//                 </Link>
//                 {/* Add other links for logged-in users */}
//                 <Link className="navlink" to="/logout">
//                   Log Out
//                 </Link>
//               </>
//             )}
//           </div>
//         </header>
//       </body>
//     </html>
//   );
// };

// export default App;



