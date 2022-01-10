import React from 'react';
import { text } from '@storybook/addon-knobs';
import LogoText from '.';

export default {
  title: 'Molecules / LogoText'
};

export const Title = () => {
  return (
    <LogoText size={'96px'} children={text('title', 'WE : ART')}></LogoText>
  );
};

export const SubTitle = () => {
  return (
    <LogoText
      size={'30px'}
      children={text('subtitle', 'Art auction platform by JNU')}
    ></LogoText>
  );
};
