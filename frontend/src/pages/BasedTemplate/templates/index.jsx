import React from 'react';

import * as S from './style';
import { NavBar } from 'components';

export default function BasedTemplate({ children, footer }) {
  if (!footer) {
    return (
      <div>
        <S.HeaderWrapper>
          <NavBar />
        </S.HeaderWrapper>
        <S.ChildrenWrapper>{children}</S.ChildrenWrapper>
      </div>
    );
  }
  return (
    <div>
      <S.HeaderWrapper>
        <NavBar />
      </S.HeaderWrapper>
      <S.ChildrenWrapper>{children}</S.ChildrenWrapper>
      <S.FooterWrapper></S.FooterWrapper>
    </div>
  );
}
