import React from 'react';
import Img from 'components/atoms/Img';

import * as Styled from './style';

function MainLinkContainer({ title, subtitle, alt, to, link }) {
  return (
    <Styled.BlackContainer>
      <div>
        <Styled.Title>{title}</Styled.Title>
        <Styled.SubTitle>{subtitle}</Styled.SubTitle>
      </div>
      <Styled.Button to={to}>
        <Styled.SubTitle>{link}</Styled.SubTitle>
        <Img width={'23px'} alt={alt} src={'assets/img/arrow-right.svg'} />
      </Styled.Button>
    </Styled.BlackContainer>
  );
}

export default MainLinkContainer;
