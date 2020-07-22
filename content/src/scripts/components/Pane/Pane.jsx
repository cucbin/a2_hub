import React, { useState, useEffect, useContext } from "react";
import { TabIdentifierClient } from "chrome-tab-identifier";

import SVG from "../SVG";
import TreeList from "../../containers/TreeList/TreeList";
import Resizer from "../../containers/Resizer";
import { OptionsContext } from "../../contexts/OptionsContext";
import { fetchURLDetails } from "../../utils/url";
import { switchTheme } from "../../utils/themeList";
import getHeaderBackgroundColor from "../../utils/backgroundColor";
import useEventListener from "../../utils/useEventListener";

import "./styles.css";

const tabIdClient = new TabIdentifierClient();

function Pane({
  toggleOpened,
  width,
  firstPageLoad,
  setFirstPageLoad,
  setShowSearchbarTrue,
  reloading,
  setReloading,
}) {
  const { options } = useContext(OptionsContext);
  const [tabId, setTabId] = useState();
  const [headerStyle, setHeaderStyle] = useState(
    getHeaderBackgroundColor(options),
  );

  useEffect(() => {
    tabIdClient.getTabId().then((tab) => {
      setTabId(tab);
    });
  }, []);

  useEffect(() => {
    if (reloading) {
      setReloading(false);
    }
  }, [reloading]);

  useEventListener("popstate", () => {
    setReloading(true);
  });

  useEffect(() => {
    setHeaderStyle(getHeaderBackgroundColor(options));
  }, [options]);

  const URLDetails = fetchURLDetails();

  return (
    <div className="gitttree-tree-pane" style={{ width: width + "px" }}>
      <div className="gitttree-pane-main">
        <div className="gitttree-pane-header" style={headerStyle}>
          <div className="gitttree-spread">
            <div className="gitttree-pane-details">
              {URLDetails.dirFormatted}
            </div>
            <span onClick={toggleOpened} className="gitttree-close-button">
                <SVG icon="close" height="12" />
            </span>
          </div>
          <div className="gitttree-spread">
            <div
              className="gitttree-pane-details"
            >
              {URLDetails.branchName}
            </div>
            <span
              onClick={setShowSearchbarTrue}
              className="gitttree-close-button"
            >
              <SVG icon="search" height="9" />
            </span>
          </div>
        </div>
        <div className="gitttree-tree-body">
          {tabId ? (
            <TreeList
              firstPageLoad={firstPageLoad}
              setFirstPageLoad={setFirstPageLoad}
              tabId={tabId}
            />
          ) : null}
        </div>
      </div>
      <Resizer />
    </div>
  );
}

export default Pane;
