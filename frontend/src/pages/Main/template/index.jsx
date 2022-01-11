import React from 'react';

import BasedTemplate from 'pages/BasedTemplate/templates';
import * as S from './style';

function MainTemplate({ categories }) {
  return (
    <BasedTemplate>
      <S.CategoryGridContainer>{categories}</S.CategoryGridContainer>
    </BasedTemplate>
  );
}

export default MainTemplate;
