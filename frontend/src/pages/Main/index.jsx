import React from 'react';
import MainTemplate from './template';

import CategoryGrid from 'components/organisms/CategoryGrid';
import MainLink from 'components/organisms/MainLink';

function Main() {
  return (
    <MainTemplate
      categories={<CategoryGrid />}
      links={<MainLink />}
    ></MainTemplate>
  );
}

export default Main;
