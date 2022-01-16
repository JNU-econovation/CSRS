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
    <div>
      <Img
        filter={'brightness(0.3)'}
        alt={'이미지'}
        src={'assets/img/mainanchorimg.png'}
      />
    </div>
  );
};

export const icon = () => {
  return (
    <div>
      <i className="fi fi-rr-Arrow-right"></i>
      <i className="fas fa-arrow-right"></i>
      <i className="fi fi-ro-arrow-right"></i>
    </div>
  );
};
