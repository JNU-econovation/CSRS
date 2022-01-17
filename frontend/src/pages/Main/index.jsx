import React from 'react';
import MainTemplate from './template';

import CategoryGrid from 'components/organisms/CategoryGrid';

function Main() {
  return <MainTemplate categories={<CategoryGrid />}></MainTemplate>;
}

export default Main;
