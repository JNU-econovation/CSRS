import React from "react";
import Img from ".";
import { text } from "@storybook/addon-knobs";
export default {
    title: "Atoms / Img",
};

export const index = () => (
    <div style={{ padding: "1rem", backgroundColor: "gray" }}>
        <div style={{ width: "100%", backgroundColor: "white" }}>
            <Img alt={text("alt", "main banner img")} src={"assets/img/logo.png"} />
        </div>
    </div>
);
