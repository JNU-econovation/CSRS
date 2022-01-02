import React from "react";
import { boolean } from "@storybook/addon-knobs";
import NavBarAuth from ".";

export default {
    title: "Molecules / NavBarAuth",
};

export const navBarNotLogin = () => {
    return <NavBarAuth isLogin={boolean("로그인", false)}></NavBarAuth>;
};
