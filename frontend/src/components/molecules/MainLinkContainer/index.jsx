import React from 'react';
import Img from 'components/atoms/Img';

import * as Styled from './style';
import { img } from 'assets/img';

function MainLinkContainer({ title, subtitle, alt, to, link }) {
  return (
    <Styled.RectangleContainer>
      <Styled.BlackContainer>
        <div>
          <Styled.Title bold>{title}</Styled.Title>
          <Styled.SubTitle>{subtitle}</Styled.SubTitle>
        </div>
        <Styled.Button to={to}>
          <Styled.SubTitle>{link}</Styled.SubTitle>
          <Img width={'23px'} alt={alt} src={img.ARROW_RIGHT} />
        </Styled.Button>
      </Styled.BlackContainer>
    </Styled.RectangleContainer>
  );
}

export default MainLinkContainer;
