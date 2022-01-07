import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import Btn from '.';
import { text } from '@storybook/addon-knobs';
export default {
  title: 'Atoms / Btn'
};

export const anchor = () => {
  return (
    <>
      <Btn children={text('Content', '로그인')} to={'/'}></Btn>
    </>
  );
};

export const imgBtn = () => {
  return (
    <Btn children={text('ax', '')} img={'url(/assets/img/logo.png)'}></Btn>
  );
};
