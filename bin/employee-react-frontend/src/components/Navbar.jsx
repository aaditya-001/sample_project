import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
	return (
		<nav className="navbar">
			<div className="navbar-brand">Employee App</div>
			<div className="navbar-links">
				<Link to="/">Home</Link>
				<Link to="/employees">Employees</Link>
			</div>
		</nav>
	);
}

export default Navbar;
