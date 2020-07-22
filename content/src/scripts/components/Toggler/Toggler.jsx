import React from "react";

import "./styles.css";

function Toggle({ pinned, handleClick }) {
  return (
    <div className="gitttree-toggler" onClick={handleClick}>
      Explore
    </div>
  );
}

export default Toggle;
