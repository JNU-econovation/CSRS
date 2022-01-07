import React from 'react';
import { boolean } from '@storybook/addon-knobs';
import NavBarButton from '.';

export default {
  title: 'Molecules / NavBarButton'
};

export const navBarAuth = () => {
  return <NavBarButton contents={['로그인', '로그아웃']}></NavBarButton>;
};

export const navBarLink = () => {
  return (
    <NavBarButton contents={['작품보기', '예술품등록', '작가']}></NavBarButton>
  );
};
