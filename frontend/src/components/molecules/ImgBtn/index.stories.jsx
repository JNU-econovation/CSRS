import React from 'react';
import { boolean } from '@storybook/addon-knobs';
import ImgBtn from '.';

export default {
  title: 'Molecules / ImgBtn'
};

export const imageBtn = () => {
  return (
    <div style={{ width: '9rem', display: 'flex' }}>
      <ImgBtn alt={'등록'} src={'/assets/img/NavImg.png'}></ImgBtn>
      <ImgBtn alt={'등록'} src={'/assets/img/NavSearch.png'}></ImgBtn>
      <ImgBtn alt={'등록'} src={'/assets/img/NavShoppingList.png'}></ImgBtn>
      <ImgBtn alt={'등록'} src={'/assets/img/NavLike.png'}></ImgBtn>
      <ImgBtn alt={'등록'} src={'/assets/img/NavAlarm.png'}></ImgBtn>
    </div>
  );
};

export const logo = () => {
  return (
    <ImgBtn alt={'로고'} width={'5em'} src={'/assets/img/logo.png'}></ImgBtn>
  );
};