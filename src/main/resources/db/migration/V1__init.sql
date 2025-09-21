create table if not exists tasks (
    id uuid primary key,
    title text not null,
    description text,
    status varchar(20) not null,
    due_at timestamptz,
    created_at timestamptz not null,
    updated_at timestamptz not null
);
