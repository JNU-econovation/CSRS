import * as S from './style';

export default function NavBarButton({ contents }) {
  return (
    <S.NavButtonContainer>
      {contents.map((content) => (
        <S.NavButton>{content}</S.NavButton>
      ))}
    </S.NavButtonContainer>
  );
}
