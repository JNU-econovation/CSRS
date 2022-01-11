import React from 'react';

import * as S from './style';

function Text({ className, bold, children }) {
  if (bold) {
    return (
      <S.Text className={className} bold>
        {children}
      </S.Text>
    );
  }
  return <S.Text className={className}>{children}</S.Text>;
}

export default Text;
