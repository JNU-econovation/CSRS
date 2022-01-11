import React from 'react';
import Img from '.';
import { text } from '@storybook/addon-knobs';
export default {
  title: 'Atoms / Img'
};

export const index = () => (
  <div style={{ padding: '1rem', backgroundColor: 'gray' }}>
    <div style={{ width: '100%', backgroundColor: 'white' }}>
      <Img alt={text('alt', 'main banner img')} src={'assets/img/logo.png'} />
    </div>
  </div>
);

export const filter = () => {
  return (
    <div style={{ backgroundColor: 'rgba(0, 0, 0, 0.7)' }}>
      <Img alt={'이미지'} src={'assets/img/mainanchorimg.png'} />
    </div>
  );
};
