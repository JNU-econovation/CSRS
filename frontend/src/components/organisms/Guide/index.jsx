import React from 'react';

import * as S from './style';
import img from 'assets/img';
import LogoText from 'components/molecules/LogoText';

function Guide() {
  return (
    <S.SplashContainer to={'/main'}>
      <S.LogoBtn alt={'logo'} src={img.LogoOnlyImage}></S.LogoBtn>
      <LogoText>WE : ART</LogoText>
      <LogoText subtitle>Art auction platform by JNU</LogoText>
      <S.GuideKr>
        경매를 통해 개인 창작물들을 자유롭게 판매하고 구매해보세요
      </S.GuideKr>
      <S.GuideKr>WE : ART 와 함께 예술의 세계를 경험하세요</S.GuideKr>
    </S.SplashContainer>
  );
}

export default Guide;
