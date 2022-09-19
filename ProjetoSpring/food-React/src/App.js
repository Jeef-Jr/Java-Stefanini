import React from "react";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom"
import Home from "./pages/home";
import Owner from "./pages/owner";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/owner" element={<Owner />}/>
      </Routes>
    </Router>
  );
}

export default App;
