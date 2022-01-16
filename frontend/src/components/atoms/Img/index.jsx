import React from 'react';

import * as S from './style';

function Img({ className, alt, src, ...props }) {
  return <S.Img className={className} alt={alt} src={src} {...props} />;
}

export default Img;
