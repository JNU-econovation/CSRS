import React from "react";
import { boolean } from "@storybook/addon-knobs";
import ImgBtn from ".";

export default {
    title: "Molecules / ImgBtn",
};

export const imageBtn = () => {
    return (
        <div style={{ width: "20px", display: "flex" }}>
            <ImgBtn width={"20px"} alt={"등록"} src={"/assets/img/NavImg.png"}></ImgBtn>
            <ImgBtn alt={"등록"} src={"/assets/img/NavSearch.png"}></ImgBtn>
            <ImgBtn alt={"등록"} src={"/assets/img/NavShoppingList.png"}></ImgBtn>
            <ImgBtn alt={"등록"} src={"/assets/img/NavLike.png"}></ImgBtn>
            <ImgBtn alt={"등록"} src={"/assets/img/NavAlarm.png"}></ImgBtn>
        </div>
    );
};
