import React from 'react';
import * as S from './style';
import BasedTemplate from 'pages/BasedTemplate/templates';

function SpalshTemplate({ guide }) {
  return (
    <BasedTemplate>
      <S.GuideContainer>{guide}</S.GuideContainer>
    </BasedTemplate>
  );
}

export default SpalshTemplate;
