import React from 'react';

import * as S from './style';

function Img({ className, alt, src }) {
  return <S.Img className={className} alt={alt} src={src} />;
}

export default Img;
