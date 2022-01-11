import React from 'react';
import Text from '.';
import { text } from '@storybook/addon-knobs';
export default {
  title: 'Atoms / Text'
};

export const span = () => {
  return <Text children={text('content', 'text')}></Text>;
};
