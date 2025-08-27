import React from "react";
import { Route, Routes } from "react-router-dom";
import App from "../App.jsx";
import ChatPage from "../components/ChatPage.jsx";

const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<App />} />
      <Route path="/about" element={<h1>About Page</h1>} />
      <Route path="/chat" element={<ChatPage />} />
      <Route path="*" element={<h1>404 Page Not Found</h1>} />
    </Routes>
  );
};

export default AppRoutes;
