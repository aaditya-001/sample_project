import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import "./index.css";

try {
  ReactDOM.createRoot(document.getElementById("root")).render(
    <React.StrictMode>
      <App />
    </React.StrictMode>
  );
} catch (err) {
  // Show the error in-page to help diagnose blank white pages during development
  console.error("Render error:", err);
  const pre = document.createElement("pre");
  pre.style.whiteSpace = "pre-wrap";
  pre.style.color = "red";
  pre.textContent = `Render error:\n${err && err.stack ? err.stack : String(err)}`;
  document.body.innerHTML = "";
  document.body.appendChild(pre);
}